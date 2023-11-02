import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserDetailsApiComponent } from './user-details-api.component';

describe('UserDetailsApiComponent', () => {
  let component: UserDetailsApiComponent;
  let fixture: ComponentFixture<UserDetailsApiComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserDetailsApiComponent]
    });
    fixture = TestBed.createComponent(UserDetailsApiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
