import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthenticateService } from 'src/app/services/authenticate.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admincontrol',
  templateUrl: './admincontrol.component.html',
  styleUrls: ['./admincontrol.component.css']
})
export class AdmincontrolComponent implements OnInit {
  user: User = new User();

  users: User[];
  userId: number;
  editFlag = false;
  info: Object;
  // tslint:disable-next-line: max-line-length
  constructor(private userService: UserService, private authService: AuthenticateService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

    this.userService.loadUsers().subscribe(data => {
      this.users = data;
      this.userService.setUsers(this.users);
    });
  }

  reloadData() {
    this.users = this.userService.getUsers();
  }
  deleteUser(userId: number) {
    this.userService.deleteUserById(userId)
      .subscribe(
        data => {
          console.log(data);
          alert('User deleted');
          this.reloadData();
        },
        error => console.log(error));
  }
  updateUser(userId: number) {

    const users: User[] = this.userService.getUsers().filter(user => user.userId === userId);
    if (users.length > 0) {
      this.user = users[0];
      this.editFlag = true;
    }

  }
  updateuser() {
    this.userService.updateUser(this.user.userId, this.user)
      .subscribe(data => console.log(data), error => console.log(error));
    this.user = new User();
    this.gotoList();
  }

  onSubmit() {
    this.editFlag = false;
    }

  gotoList() {
    this.router.navigate(['/employees']);
  }
  editUser(): void {
      this.editFlag = false;
    }
    logout() {
      this.authService.logout();
      this.router.navigateByUrl('/admin');
      this.userService.logout(this.userId).subscribe(data => {
        this.info = data;
    });
  }

}
