import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ObjectData} from '../../model/object-data';
import {ObjectType} from '../../model/object-type';
import {ObjectServiceService} from '../../service/object-service.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-object-create',
  templateUrl: './object-create.component.html',
  styleUrls: ['./object-create.component.css']
})
export class ObjectCreateComponent implements OnInit {
  objectForm: FormGroup;
  objectData: ObjectData;
  objectTypeList: ObjectType[];

  constructor(private  objectServiceService: ObjectServiceService,
              private activeRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllType();
    this.objectForm = new FormGroup({
      id: new FormControl(),
      objectName: new FormControl('', Validators.pattern('^[a-z A-Z]{1,50}$')),
      objectType: new FormControl(),
    });
  }

  createObject(): void {
    this.objectData = this.objectForm.value;
    this.objectServiceService.saveObjectData(this.objectData).subscribe(value => {

    }, error => {

    }, () => {
      alert('Add successfully!');
      this.router.navigateByUrl('/object/list');
    });
  }

  getAllType(): void {
    this.objectServiceService.getAllObjectDataType().subscribe(value => {
      this.objectTypeList = value;
    });
  }
}
