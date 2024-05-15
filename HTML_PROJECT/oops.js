class person {
	constructor(name) {
		this.name = name;
	}
	toString() {
		return (`Name of person: ${this.name}`);
	}
}

class student extends person {
	constructor(name, id) {
		super(name);
		this.id = id;
	}
	toString() {
		return (`${super.toString()}, Student ID: ${this.id}`);
	}
}
let student1 = new student('Muzamil', 22);
console.log(student1.toString());


// Abstraction example
function persondetail(fname, lname) {
	let firstname = fname;
	let lastname = lname;

	let getDetails_noaccess = function () {
		return (`First name is: ${firstname} Last name is: ${lastname}`);
	}

	this.getDetails_access = function () {
		return (`First name is: ${firstname}, Last name is: ${lastname}`);
	}
}
let person1 = new persondetail('Muzamil', 'S');
console.log(person1.firstname);
console.log(person1.getDetails_noaccess());
console.log(person1.getDetails_access());
