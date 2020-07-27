import { Component, OnInit } from '@angular/core';
import { UserService } from './../../services/user.service';
import { User } from './../../models/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  name: string = 'nombre de usuario';

  user: User = { id: 0, name: '', nameUser: '' };
  constructor(private service: UserService) {}

  ngOnInit(): void {
    this.service.listar().subscribe((user) => (this.user = user));
  }
}
