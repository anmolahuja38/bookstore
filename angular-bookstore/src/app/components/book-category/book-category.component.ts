import { Component, OnInit } from '@angular/core';
import { BookCategory } from 'src/app/common/book-category';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-book-category',
  templateUrl: './book-category.component.html',
  styleUrls: ['./book-category.component.css']
})
export class BookCategoryComponent implements OnInit {

  constructor(private _bookService : BookService) { }

  ngOnInit(): void {
    this.listBookCategory();
  }

  bookCategory : BookCategory[];

  listBookCategory()
  {
    this._bookService.getCategory().subscribe(
      data => {
        this.bookCategory=data;
        //console.log(data);
      }
    )
  }

}
