import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../../services/profile-service.service';
import { Profile } from '../../models/profile';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profile: Profile;
  profileName: string;
  userType: string;
  userName: string;
  urlImage: string;
  userUrlHref: string;
  userFollowerCount:string;

  constructor(private service: ProfileService) {}

  ngOnInit() {

   this.service.listar().subscribe( profile => {
     this.profile = profile;
     this.userType = this.profile.type;
     this.userUrlHref = this.profile.external_urls['spotify'];
     this.userName = this.profile.display_name;
     this.urlImage = this.profile.image[0]['url'];
     this.userFollowerCount = this.profile.followers['total'];

   });

  }

  onclick()
  {
    console.log(this.profile.display_name);
  }

}
