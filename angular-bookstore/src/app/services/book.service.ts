import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Book } from '../common/book';
import { BookCategory } from '../common/book-category';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseUrl = "http://localhost:8080/api/v1";
  constructor(private httpClient: HttpClient) { }

  getBooks(): Observable<Book[]> {
    const url = `${this.baseUrl}/books`
    return this.httpClient.get<GetResponseBooks>(this.baseUrl).pipe(
      map(response => response.body)
    );
  }

  getCategory(): Observable<BookCategory[]> {
    const url = `${this.baseUrl}/category`;
    return this.httpClient.get<getResponseCategory>(url).pipe(
      map(response => response.body)
    );
  }

  getBooksByCategory(categoryId: number) {
    const url = `${this.baseUrl}/books/category?id=${categoryId}`;
    return this.httpClient.get<GetResponseBooks>(url).pipe(
      map(response => response.body)
    );
  }

  searchBooksByKeyword(keyword: string): Observable<Book[]> {
    const url = `${this.baseUrl}/books/search?name=${keyword}`;
    console.log(url);
    return this.httpClient.get<GetResponseBooks>(url).pipe(
      map(response => response.body)
    );
  }

  getBookDetails(bookId: number) {
    const url = `${this.baseUrl}/books/${bookId}`;
    return this.httpClient.get<GetResponseBook>(url).pipe(
      map(response => response.body)
    );
  }
}

interface GetResponseBooks {
  body: Book[];
}

interface GetResponseBook {
  body : Book;
}

interface getResponseCategory {
  body: BookCategory[];
}
