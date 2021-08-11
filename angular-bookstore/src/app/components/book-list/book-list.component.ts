import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/common/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
})
export class BookListComponent implements OnInit {
  constructor(
    private _bookService: BookService,
    private _activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this._activatedRoute.paramMap.subscribe(() => {
      this.listBooks();
    });
  }

  books: Book[] = [];
  currentCategoryId: number;
  searchMode: boolean;
  pageSize: number = 5;
  currentPage: number = 1;
  totalRecords : number = 0;

  listBooks() {
    this.searchMode = this._activatedRoute.snapshot.paramMap.has('keyword');
    if (this.searchMode) {
      //do the search work
      this.handleSearchBooks();
    } else {
      //handle the list book method
      this.handleListBook();
    }
  }

  handleSearchBooks() {
    const keyword: string =
      this._activatedRoute.snapshot.paramMap.get('keyword');
    this._bookService
      .searchBooksByKeyword(keyword, this.currentPage - 1, this.pageSize)
      .subscribe(this.processPaginate());
  }

  updatePageSize(pageSize: number) {
    this.pageSize = pageSize;
    this.currentPage=1;
    this.listBooks();
  }

  processPaginate(){
    return data => {
      this.books=data.books;
      console.log(data);
      this.currentPage=data.number+1;
      this.totalRecords=data.totalElements;
      this.pageSize=data.pageSize;
    }
  }

  handleListBook() {
    const hasCategoryid: boolean =
      this._activatedRoute.snapshot.paramMap.has('id');
    if (hasCategoryid) {
      this.currentCategoryId =
        +this._activatedRoute.snapshot.paramMap.get('id');
    } else {
      this.currentCategoryId = 1;
    }
    this._bookService
      .getBooksByCategory(this.currentCategoryId, this.currentPage-1, this.pageSize)
      .subscribe( this.processPaginate());
  }
}
