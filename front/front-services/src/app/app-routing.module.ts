import { UserComponent } from './components/user/user.component';
import { SongComponent } from './components/song/song.component';
import { PlaylistComponent } from './components/playlist/playlist.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfileComponent } from './components/profile/profile.component';

const routes: Routes = [
  // { path: '', pathMatch: 'full', redirectTo: 'user' },

  { path: 'user', component: UserComponent },
  { path: 'song', component: SongComponent },
  { path: 'playlist', component: PlaylistComponent },
  { path: 'profile', component: ProfileComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
