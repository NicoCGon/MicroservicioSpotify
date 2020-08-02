import { Component, OnInit } from '@angular/core'
import { FormGroup, FormControl } from '@angular/forms'
import { PlaylistService } from './../../services/playlist.service'
import { UserPlaylist } from './../../models/user-playlist'
import { Infoplaylist } from './../../models/infoplaylist'
@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent implements OnInit {
  userPlay: UserPlaylist
  infoPlaylist: Infoplaylist = new Infoplaylist(
    '',
    '',
    false,
    localStorage.getItem('idUser')
  )
  modificarPlaylist = new FormGroup({
    name: new FormControl(''),
    description: new FormControl(''),
    tipo: new FormControl(false),
    id: new FormControl(false)
  })

  profileForm = new FormGroup({
    name: new FormControl(''),
    description: new FormControl(''),
    tipo: new FormControl(false)
  })
  constructor (private service: PlaylistService) {}

  ngOnInit (): void {
    this.service.listar().subscribe(userP => {
      this.userPlay = userP
    })
  }

  onSubmit () {
    const { name, description, tipo } = this.profileForm.value
    let id: string = localStorage.getItem('idUser')
    const playlist = new Infoplaylist(name, description, tipo, id)
    this.service.createdPlaylist(playlist).subscribe(s => {})
  }

  enviarInfo (playlist) {
    console.warn(playlist)
    this.modificarPlaylist.patchValue({
      name: playlist.name,
      description: playlist.description,
      id: playlist.id
    })
  }

  modificar () {
    console.log(this.modificarPlaylist.value)
    const { name, description, tipo, id } = this.modificarPlaylist.value
    let idUser: string = localStorage.getItem('idUser')
    const playlist = new Infoplaylist(name, description, tipo, idUser)
    this.service.modificarPlaylist(playlist, id).subscribe(s => {})
  }
}
