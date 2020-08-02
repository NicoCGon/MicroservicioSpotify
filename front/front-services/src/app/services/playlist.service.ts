import { Injectable } from '@angular/core'
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs'
import { UserPlaylist } from '../models/user-playlist'
import { Infoplaylist } from '../models/infoplaylist'

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {
  private baseEndpoint = 'http://localhost:8080/Java-Web-Playlist'
  private cabeceras: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json'
  })

  constructor (private http: HttpClient) {}

  public listar (): Observable<UserPlaylist> {
    let id: string = localStorage.getItem('idUser')
    return this.http.get<UserPlaylist>(
      `${this.baseEndpoint}/playlist/?id=${id}`
    )
  }

  public createdPlaylist (playlist: Infoplaylist): Observable<string> {
    return this.http.post<string>(
      `${this.baseEndpoint}/playlist/new`,
      playlist,
      { headers: this.cabeceras }
    )
  }
  public modificarPlaylist (
    playlist: Infoplaylist,
    id: string
  ): Observable<string> {
    return this.http.put<string>(
      `${this.baseEndpoint}/playlists/${id}`,
      playlist,
      { headers: this.cabeceras }
    )
  }
}
