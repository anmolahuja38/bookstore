import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Book } from 'src/app/common/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  constructor(private _activatedRoute: ActivatedRoute,
    private _bookService: BookService) { }

  ngOnInit(): void {
    this._activatedRoute.paramMap.subscribe(() => {
      this.getBookDetails();
    })
  }

  book: Book = new Book();

  getBookDetails() {
    const id: number = +this._activatedRoute.snapshot.paramMap.get('id');
    this._bookService.getBookDetails(id).subscribe(
      data => {
        this.book = data;
      }
    )
  }

}
