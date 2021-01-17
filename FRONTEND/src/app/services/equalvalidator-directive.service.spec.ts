import { TestBed } from '@angular/core/testing';

import { EqualvalidatorDirectiveService } from './equalvalidator-directive.service';

describe('EqualvalidatorDirectiveService', () => {
  let service: EqualvalidatorDirectiveService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EqualvalidatorDirectiveService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
