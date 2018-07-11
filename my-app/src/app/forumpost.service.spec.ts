import { TestBed, inject } from '@angular/core/testing';

import { ForumpostService } from './forumpost.service';

describe('ForumpostService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ForumpostService]
    });
  });

  it('should be created', inject([ForumpostService], (service: ForumpostService) => {
    expect(service).toBeTruthy();
  }));
});
