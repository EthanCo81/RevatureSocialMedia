import { User } from './user';

export class Employee extends User {
    id: number;
    username: string;
    password: string;
    picture: object;
    firstname: string;
    lastname: string;
    aboutme: string;
    technologies: string;
}
