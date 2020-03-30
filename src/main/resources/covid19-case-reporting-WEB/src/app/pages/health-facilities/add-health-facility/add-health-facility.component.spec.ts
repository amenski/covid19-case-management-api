import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddHealthFacilityComponent } from './add-health-facility.component';

describe('AddRoutesComponent', () => {
  let component: AddHealthFacilityComponent;
  let fixture: ComponentFixture<AddHealthFacilityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddHealthFacilityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddHealthFacilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
