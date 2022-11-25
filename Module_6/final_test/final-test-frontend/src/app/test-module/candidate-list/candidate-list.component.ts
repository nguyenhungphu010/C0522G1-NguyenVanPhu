import {Component, OnInit} from '@angular/core';
import {CandidateService} from '../../service/candidate.service';
import {Title} from '@angular/platform-browser';
import {BehaviorSubject, Observable} from 'rxjs';
import {Candidate} from '../../model/candidate';
import {FormControl, FormGroup} from '@angular/forms';
import {CandidateType} from '../../model/candidate-type';
import {InterviewRecord} from '../../model/interview-record';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-candidate-list',
  templateUrl: './candidate-list.component.html',
  styleUrls: ['./candidate-list.component.css']
})
export class CandidateListComponent implements OnInit {
  page = 1;
  pageSize = 5;
  total$: Observable<number>;
  nameSearch = '';
  typeSearch: number;
  action: boolean;

  candidateList: Candidate[];
  candidateIdDelete: number;
  deleteName: string;

  candidateForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    dayOfBirth: new FormControl(),
    phoneNumber: new FormControl(),
    experiencedYear: new FormControl(),
    specialist: new FormControl(),
    graduatedYear: new FormControl(),
    graduatedResult: new FormControl(),
    graduatedSchool: new FormControl(),
    major: new FormControl(),
    currentSemester: new FormControl(),
    candidateType: new FormControl(),
    interviewRecordInterviewer: new FormControl(),
    interviewRecordResult: new FormControl(),
    interviewRecordTime: new FormControl(),
    interviewRecordComment: new FormControl(),
    interviewRecordSalary: new FormControl()
  });

  constructor(private candidateService: CandidateService,
              private title: Title) {
    this.title.setTitle('Candidate List');
  }

  ngOnInit(): void {
    this.paginate();
  }

  getInfoCandidate(candidateId: number, candidateName: string,
                   candidateDayOfBirth: string, candidatePhoneNumber: string,
                   experiencedYear: number, specialist: string,
                   graduatedYear: string, graduatedResult: string,
                   graduatedSchool: string, major: string,
                   currentSemester: number, candidateType: string,
                   interviewer: string, interviewResult: string,
                   interviewTime: string, comment: string,
                   salary: number): void {
    this.candidateForm.controls.id.setValue(candidateId);
    this.candidateForm.controls.name.setValue(candidateName);
    this.candidateForm.controls.dayOfBirth.setValue(candidateDayOfBirth);
    this.candidateForm.controls.phoneNumber.setValue(candidatePhoneNumber);
    this.candidateForm.controls.experiencedYear.setValue(experiencedYear);
    this.candidateForm.controls.specialist.setValue(specialist);
    this.candidateForm.controls.graduatedYear.setValue(graduatedYear);
    this.candidateForm.controls.graduatedResult.setValue(graduatedResult);
    this.candidateForm.controls.graduatedSchool.setValue(graduatedSchool);
    this.candidateForm.controls.major.setValue(major);
    this.candidateForm.controls.currentSemester.setValue(currentSemester);
    this.candidateForm.controls.candidateType.setValue(candidateType);
    this.candidateForm.controls.interviewRecordInterviewer.setValue(interviewer);
    this.candidateForm.controls.interviewRecordResult.setValue(interviewResult);
    this.candidateForm.controls.interviewRecordTime.setValue(interviewTime);
    this.candidateForm.controls.interviewRecordComment.setValue(comment);
    this.candidateForm.controls.interviewRecordSalary.setValue(salary);
    this.deleteName = candidateName;
  }

  deleteEmployee(): void {
    this.candidateIdDelete = Number(this.candidateForm.value.id);
    this.candidateService.deleteCandidate(this.candidateIdDelete).subscribe(value => {
      this.ngOnInit();
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'delete successfully',
        showConfirmButton: false,
        timer: 2700
      });
    }, error => {
    }, () => {
    });
  }

  paginate() {
    this.candidateService.paginate(this.page, this.pageSize, this.nameSearch,
      this.typeSearch).subscribe(data => {
      console.log(data);
      console.log(this.typeSearch);
      if (data != null) {
        this.action = true;
        this.candidateList = data.content;
        this.total$ = new BehaviorSubject<number>(data.totalElements);
      } else {
        this.action = false;
      }
    });
    // this.nameSearch = '';
    // this.idCardSearch = '';
    // this.phoneNumberSearch = '';
  }
}
