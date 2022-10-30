import {Component, OnInit} from '@angular/core';
import {ObjectServiceService} from '../../service/object-service.service';
import {ObjectData} from '../../model/object-data';
import {Router} from '@angular/router';

@Component({
  selector: 'app-object-list',
  templateUrl: './object-list.component.html',
  styleUrls: ['./object-list.component.css']
})
export class ObjectListComponent implements OnInit {
  objectList: ObjectData[];
  objectIdDelete: number;
  objectNameDelete: string;

  constructor(private objectServiceService: ObjectServiceService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.objectServiceService.getAll().subscribe(value => {
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
    }, error => {
    }, () => {
      alert('delete successfully');
    });
  }
}
