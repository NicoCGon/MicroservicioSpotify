import {Component, OnInit, Input} from '@angular/core';
import {PlaylistService} from './../../services/playlist.service';
import {UserPlaylist} from './../../models/user-playlist';
import {TracksService} from '../../services/tracks.service';
import {Track} from '../../models/track';
import {TrackList} from '../../models/trackList';

@Component({selector: 'app-playlist', templateUrl: './playlist.component.html', styleUrls: ['./playlist.component.css']})
export class PlaylistComponent implements OnInit {

    @Input()inTracks : any;

    userPlay : UserPlaylist;
    listaTracks : TrackList[];
    playlistTitle : string;
    itemTracks : [];

    constructor(private service : PlaylistService, private serviceTracks : TracksService) {}

    ngOnInit(): void {
        this.service.listar().subscribe((userP) => {
            this.userPlay = userP;
        });
        console.log(this.listaTracks);
    }


    toViewTrack(event : any): void {
        this.playlistTitle = event.currentTarget.name;
        this.serviceTracks.listar(event.currentTarget.id).subscribe((trackG) => {
            this.listaTracks = trackG;
            this.itemTracks = trackG['items'];
            console.log(trackG);
        });
        console.log(this.listaTracks);

    }
}
