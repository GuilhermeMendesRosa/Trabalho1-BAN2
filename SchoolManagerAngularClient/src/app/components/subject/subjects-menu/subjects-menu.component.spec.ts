import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubjectsMenuComponent } from './subjects-menu.component';

describe('SubjectsMenuComponent', () => {
  let component: SubjectsMenuComponent;
  let fixture: ComponentFixture<SubjectsMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubjectsMenuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubjectsMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
