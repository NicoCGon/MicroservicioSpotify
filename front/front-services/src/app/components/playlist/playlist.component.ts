import { Component, OnInit } from '@angular/core';
import { PlaylistService } from './../../services/playlist.service';
import { UserPlaylist } from './../../models/user-playlist';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css'],
})
export class PlaylistComponent implements OnInit {
  userPlay: UserPlaylist;
  constructor(private service: PlaylistService) {}

  ngOnInit(): void {
    this.service.listar().subscribe((userP) => {
      this.userPlay = userP;
    });
  }
}
