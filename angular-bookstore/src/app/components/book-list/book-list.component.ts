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
  pageOfItems: Array<Book>;
  pageSize: number = 6;

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
    this._bookService.searchBooksByKeyword(keyword).subscribe((data) => {
      this.books = data;
    });
  }

  onPageChange(pageOfItems: Array<Book>) {
    this.pageOfItems = pageOfItems;
  }

  updatePageSize(pageSize : number){
    this.pageSize=pageSize;
    this.listBooks();
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
      .getBooksByCategory(this.currentCategoryId)
      .subscribe((data) => {
        this.books = data;
      });
  }
}
