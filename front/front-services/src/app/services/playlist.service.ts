import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserPlaylist } from '../models/user-playlist';

@Injectable({
  providedIn: 'root',
})
export class PlaylistService {
  private baseEndpoint = 'http://localhost:8080/Java-Web-Playlist';

  constructor(private http: HttpClient) {}

  public listar(): Observable<UserPlaylist> {
    let id: string = localStorage.getItem('idUser');
    return this.http.get<UserPlaylist>(
      `${this.baseEndpoint}/playlist/?id=${id}`
    );
  }
}
