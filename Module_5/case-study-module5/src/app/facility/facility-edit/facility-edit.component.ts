import {Component, OnInit} from '@angular/core';
import {FacilityService} from "../../service/facility.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";
import {Facility} from "../../model/facility/facility";
import {RentType} from "../../model/facility/rent-type";
import {FacilityType} from "../../model/facility/FacilityType";

declare function jsFunction(): any;

@Component({
  selector: 'app-facility-edit',
  templateUrl: './facility-edit.component.html',
  styleUrls: ['./facility-edit.component.css']
})
export class FacilityEditComponent implements OnInit {
  facilityForm: FormGroup;
  facilityId: number;
  facility: Facility;
  rentTypeList: RentType[];
  facilityTypeList: FacilityType[];
  facilityTypeDisplay: string;


  constructor(private facilityService: FacilityService,
              private router: Router,
              private activeRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(value => {
      this.facilityId = Number(value.get('id'));
    })
    alert(this.facilityId);
    this.facilityService.findById(this.facilityId).subscribe(value => {
      this.facilityTypeDisplay = value.facilityType.facilityTypeName;
      this.facility = value;
      this.facilityForm.patchValue(this.facility);
      jsFunction();
    });
    this.facilityForm = new FormGroup({
      id: new FormControl(),
      facilityName: new FormControl(),
      facilityArea: new FormControl(),
      facilityCost: new FormControl(),
      maxPeople: new FormControl(),
      rentType: new FormControl(),
      facilityType: new FormControl(),
      standardRoom: new FormControl(),
      descriptionOtherConvenience: new FormControl(),
      poolArea: new FormControl(),
      numberOfFloors: new FormControl(),
      facilityFree: new FormControl(),
    });

    this.getAllFacilityType();
    this.getAllRentType();
  }

  getAllRentType() {
    this.facilityService.getAllRentType().subscribe(value => {
      this.rentTypeList = value;
    });
  }

  getAllFacilityType() {
    this.facilityService.getAllFacilityType().subscribe(value => {
      this.facilityTypeList = value;
    })
  }

  updateFacility(): void {
    const facilityAfter = this.facilityForm.value;
    this.facilityService.updateFacility(facilityAfter).subscribe(value => {

    }, error => {

    }, () => {
      alert("update successfully");
      this.router.navigateByUrl('facility/list');
    })
  }
  compareWithId(item1, item2) {
    return item1 && item2 && item1.id === item2.id;
  }
}
