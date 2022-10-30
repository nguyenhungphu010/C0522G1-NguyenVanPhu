import {Component, OnInit} from '@angular/core';
import {ObjectServiceService} from '../../service/object-service.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {ObjectData} from '../../model/object-data';
import {ObjectType} from '../../model/object-type';

@Component({
  selector: 'app-object-edit',
  templateUrl: './object-edit.component.html',
  styleUrls: ['./object-edit.component.css']
})
export class ObjectEditComponent implements OnInit {

  objectForm: FormGroup;
  objectId: number;
  objectData: ObjectData;
  objectTypeList: ObjectType[];

  constructor(private  objectServiceService: ObjectServiceService,
              private activeRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(value => {
      this.objectId = Number(value.get('id'));
    });
    alert(this.objectId);
    this.objectServiceService.findById(this.objectId).subscribe(value => {
      this.objectData = value;
      this.objectForm.patchValue(this.objectData);
    });
    this.objectForm = new FormGroup({
      id: new FormControl(),
      customerName: new FormControl(),
      customerEmail: new FormControl(),
      customerPhone: new FormControl(),
      customerAddress: new FormControl(),
      customerType: new FormControl(),
      customerBirthday: new FormControl(),
      customerGender: new FormControl(),
      customerIdCard: new FormControl(),
    });
    this.getAllType();
    console.log(this.objectData);
  }

  getAllType(): void {
    this.objectServiceService.getAllObjectDataType().subscribe(value => {
      this.objectTypeList = value;
    });
  }

  updateCustomer(): void {
    const customerAfter = this.objectForm.value;
    customerAfter.id = this.objectData.id;
    this.objectServiceService.updateObjectData(customerAfter).subscribe(value => {

    }, error => {

    }, () => {
      alert('update successfully');
      this.router.navigateByUrl('object/list');
    });
  }
}
