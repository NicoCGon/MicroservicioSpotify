export class Infoplaylist {
  name: string
  description: string
  tipo: boolean
  idUser: string

  constructor (
    name: string,
    description: string,
    tipo: boolean,
    idUser: string
  ) {
    this.name = name
    this.tipo = tipo
    this.description = description
    this.idUser = idUser
  }
}
