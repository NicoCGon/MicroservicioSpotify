import { Playlist } from './playlist';

export class UserPlaylist {
  href: string;
  items: Playlist[];
  limit: number;
  next: string;
  offset: number;
  previous: string;
  total: number;
}
