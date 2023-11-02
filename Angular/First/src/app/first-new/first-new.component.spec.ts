import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FirstNewComponent } from './first-new.component';

describe('FirstNewComponent', () => {
  let component: FirstNewComponent;
  let fixture: ComponentFixture<FirstNewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FirstNewComponent]
    });
    fixture = TestBed.createComponent(FirstNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
