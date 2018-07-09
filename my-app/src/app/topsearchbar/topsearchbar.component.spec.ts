import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TopsearchbarComponent } from './topsearchbar.component';

describe('TopsearchbarComponent', () => {
  let component: TopsearchbarComponent;
  let fixture: ComponentFixture<TopsearchbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TopsearchbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TopsearchbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
