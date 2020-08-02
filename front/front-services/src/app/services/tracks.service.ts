import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TrackList } from '../models/trackList';

@Injectable({
  providedIn: 'root'
})
export class TracksService {

  private baseEndpoint = 'http://localhost:8080/Java-Web-Playlist/playlists';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) {}

  public listar(idPlayList: string): Observable<TrackList[]> {
    const id: string = localStorage.getItem('idUser');
    return this.http.get<TrackList[]>(`${this.baseEndpoint}/${idPlayList}/tracks/${id}`);
  }
}
