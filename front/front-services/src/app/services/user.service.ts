import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private baseEndpoint = 'http://localhost:8080/Java-Web-Login';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) {}

  public listar(code): Observable<User> {
    return this.http.get<User>(`${this.baseEndpoint}/login/${code}`);
  }
}
