
import { Client } from 'src/app/client';
import { Employee } from 'src/app/employee';
import { Instructor } from 'src/app/instructor';
import { InstructorService } from './instructor.service';

export class CurrentUser {
    employee: Employee;
    client: Client;
    instructor: Instructor;
}
