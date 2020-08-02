import { BrowserModule } from '@angular/platform-browser'
import { NgModule } from '@angular/core'
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module'
import { AppComponent } from './app.component'
import { UserComponent } from './components/user/user.component'
import { SongComponent } from './components/song/song.component'
import { PlaylistComponent } from './components/playlist/playlist.component'
import { LayoutModule } from './layout/layout.module';
import { TracksComponent } from './components/tracks/tracks.component'

@NgModule({
  declarations: [AppComponent, UserComponent, SongComponent, PlaylistComponent, TracksComponent],
  imports: [BrowserModule, AppRoutingModule, LayoutModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
