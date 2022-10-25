import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {CategoryService} from '../../service/category.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Category} from '../../model/category';

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {
  categoryForm: FormGroup;
  categoryId: number;
  category: Category;

  constructor(private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.categoryId = +paramMap.get('id');
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

  updateCategory(): void {
    const categoryAfter = this.categoryForm.value;
    categoryAfter.id = this.category.id;
    this.categoryService.updateCategory(categoryAfter).subscribe(value => {

    }, error => {

    }, () => {
      alert(' update successfully');
      this.router.navigateByUrl('/category/list');
    });
  }
}
