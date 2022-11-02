import {Component, OnInit} from '@angular/core';
import {ObjectServiceService} from '../../service/object-service.service';
import {ObjectData} from '../../model/object-data';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-object-list',
  templateUrl: './object-list.component.html',
  styleUrls: ['./object-list.component.css']
})
export class ObjectListComponent implements OnInit {
  objectList: ObjectData[];
  objectIdDelete: number;
  objectNameDelete: string;
  p = 1;

  customerNameSearch = '';
  customerIdSearch = '';

  constructor(private objectServiceService: ObjectServiceService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.objectServiceService.searchCustomerByName(this.customerNameSearch, this.customerIdSearch).subscribe(value => {
      this.objectList = value;
    }, error => {

    }, () => {
      console.log('complete');
    });
  }

  getInfoObjectDelete(objectId: number, objectName: string): void {
    this.objectIdDelete = objectId;
    this.objectNameDelete = objectName;
  }

  deleteObject(): void {
    this.objectServiceService.deleteObjectData(this.objectIdDelete).subscribe(value => {
      this.ngOnInit();
      // @ts-ignore
      Swal.fire({
        position: 'center',
        icon: 'info',
        title: 'Delete successfully',
        showConfirmButton: false,
        timer: 1500
      });
      console.log(this.objectList);
    }, error => {
    }, () => {
      // alert('delete successfully');
    });
  }

  searchByMore(): void {
    this.ngOnInit();
  }
}
