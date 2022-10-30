import {Component, OnInit} from '@angular/core';
import {FacilityService} from "../../service/facility.service";
import {Router} from "@angular/router";
import {Facility} from "../../model/facility/facility";

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {

  facilityList: Facility [];
  facilityIdDelete: number;
  facilityNameDelete: string;
  p: number = 1;


  constructor(private facilityService: FacilityService,
              private router: Router) {

  }

  ngOnInit(): void {
    this.getAllFacility();
  }

  getAllFacility(): void {
    this.facilityService.getAll().subscribe(value => {
      this.facilityList = value;
    }, error => {

    }, () => {
      console.log("complete")
    })
  }

  getInfoFacilityDelete(facilityId: number, facilityName: string): void {
    this.facilityIdDelete = facilityId;
    this.facilityNameDelete = facilityName;
  }

  deleteFacility(): void {
    this.facilityService.deleteFacility(this.facilityIdDelete).subscribe(value => {
      this.ngOnInit();
    }, error => {

    }, () => {
      alert("delete successfully")
    })
  }

}
