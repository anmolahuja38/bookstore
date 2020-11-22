import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Book } from 'src/app/common/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  constructor(private _bookService: BookService,
    private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {

    this._activatedRoute.paramMap.subscribe(() => {
      this.listBooks();
    })
  }

  books: Book[] = [];
  currentCategoryId: number;

  listBooks() {
    const hasCategoryid: boolean = this._activatedRoute.snapshot.paramMap.has('id');
    if (hasCategoryid) {
      this.currentCategoryId=+this._activatedRoute.snapshot.paramMap.get('id');
    }else{
      this.currentCategoryId=1;
    }
    this._bookService.getBooksByCategory(this.currentCategoryId).subscribe(
      data => {
        this.books = data;
      }
    )
  }
}
