
import { Client } from './client';
import { Employee } from './employee';
import { Instructor } from './instructor';
import { InstructorService } from './instructor.service';

export class CurrentUser {
    employee: Employee;
    client: Client;
    instructor: Instructor;
}
