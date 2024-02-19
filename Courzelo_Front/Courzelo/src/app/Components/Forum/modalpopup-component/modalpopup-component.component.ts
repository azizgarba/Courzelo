import { Component, Inject } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import { MdbModalRef } from 'mdb-angular-ui-kit/modal';

@Component({
  selector: 'app-modalpopup-component',
  templateUrl: './modalpopup-component.component.html',
  styleUrls: ['./modalpopup-component.component.css']
})
export class ModalpopupComponentComponent {
  registerForm!: FormGroup;
  ngDropdown ="Choose";

  constructor(public modalRef: MdbModalRef<ModalpopupComponentComponent>) {}
  close(): void {
    const closeMessage = 'Modal closed';
    this.modalRef.close(closeMessage)
  }
  ngOnInit(){

    this.registerForm= new FormGroup({
      id:new FormControl(),
      title: new FormControl('',[Validators.required,Validators.minLength(5)]),
      description: new FormControl('',[Validators.required,Validators.minLength(5)]),
      module:new FormControl('',Validators.required)
    

    });
  }
  onSubmit(){
    console.log(this.registerForm.value);
    alert('SUCCES\n\n'+ JSON.stringify(this.registerForm.value,null,4))
  }
  
 
}
