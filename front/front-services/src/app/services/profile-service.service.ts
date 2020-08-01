import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { Profile } from '../models/profile';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  private baseEndpoint = 'http://localhost:8080/Java-Web-Profile/profile';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) {}

  public listar(): Observable<Profile> {
    let id: string = localStorage.getItem('idUser');
    return this.http.get<Profile>(`${this.baseEndpoint}/?id=${id}`);
  }
}
