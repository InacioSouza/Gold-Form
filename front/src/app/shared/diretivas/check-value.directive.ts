import { Directive, Input, OnChanges, SimpleChanges } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator, ValidatorFn } from '@angular/forms';

@Directive({
  selector: '[appCheckValue]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: CheckValueDirective,
    multi: true
  }]
})
export class CheckValueDirective implements Validator, OnChanges {
  @Input('appCheckValue') targetValue: any;

  private validatorFn: ValidatorFn = () => null;
  private onChange?: () => void;

  ngOnChanges(changes: SimpleChanges): void {
    if ('targetValue' in changes) {
      this.validatorFn = this.createValidator();
      if (this.onChange) {
        this.onChange();
      }
    }
  }

  validate(control: AbstractControl): ValidationErrors | null {
    return this.validatorFn(control);
  }

  registerOnValidatorChange(fn: () => void): void {
    this.onChange = fn;
  }

  private createValidator(): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      const currentValue = control.value;
      return currentValue !== this.targetValue ? { valorDiferente: true } : null;
    };
  }
}