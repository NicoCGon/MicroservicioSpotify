import { Component } from '@angular/core';
import { UserService } from './services/user.service';
import { User } from './models/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'front-services';
  idUser: User;

  constructor(private service: UserService) {

    if (location.search.indexOf('code') < 1) {
      window.location.assign(
        'https://accounts.spotify.com/authorize?client_id=c444f9c5b8ed428380e8c1453a2878cb&response_type=code&redirect_uri=http://localhost:4200&scope=user-read-private%20user-read-email%20user-follow-read%20playlist-modify-public%20playlist-modify-private%20playlist-read-collaborative%20playlist-read-private'
      );
    } else {
      let paramms: string[] = location.search.split('=');
      service.listar(`?code=${paramms[1]}`).subscribe((user) => {
        this.idUser = user;
        localStorage.setItem('idUser', this.idUser.id);
        console.log(this.idUser);
      });
    }
  }
}
