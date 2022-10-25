import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {CategoryService} from '../../service/category.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Category} from '../../model/category';

@Component({
  selector: 'app-category-delete',
  templateUrl: './category-delete.component.html',
  styleUrls: ['./category-delete.component.css']
})
export class CategoryDeleteComponent implements OnInit {
  categoryForm: FormGroup;
  categoryId: number;
  category: Category;

  constructor(private categoryService: CategoryService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(value => {
      this.categoryId = Number(value.get('id'));
    });
    this.categoryService.findById(this.categoryId).subscribe(value => {
      this.category = value;
      this.categoryForm.patchValue(this.category);
    });
    this.categoryForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl(),
    });
  }


  deleteCategory(id: number) {
    this.categoryService.deleteCategory(id).subscribe(value => {

    }, error => {

    }, () => {
      alert('Delete successfull');
      this.router.navigateByUrl('/category/list');
    });
  }

}
