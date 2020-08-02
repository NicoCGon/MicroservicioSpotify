import { Component, OnInit } from '@angular/core';
import { TracksService } from '../../services/tracks.service';

@Component({
  selector: 'app-tracks',
  templateUrl: './tracks.component.html',
  styleUrls: ['./tracks.component.css']
})
export class TracksComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
