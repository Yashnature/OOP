class Book:
    def __init__(self, book_id, title, author):
        self.book_id = book_id
        self.title = title
        self.author = author
        self.is_issued = False

    def __str__(self):
        return f"Book ID: {self.book_id}, Title: {self.title}, Author: {self.author}"
class Member:
    def __init__(self, member_id, name):
        self.member_id = member_id
        self.name = name

    def __str__(self):
        return f"Member ID: {self.member_id}, Name: {self.name}"
class Transaction:
    def __init__(self):
        self.transactions = []

    def issue_book(self, book, member):
        if book.is_issued:
            print(f"Cannot issue '{book.title}' to {member.name}. It's already issued.")
        else:
            book.is_issued = True
            self.transactions.append(('Issued', book, member))
            print(f"Book '{book.title}' issued to {member.name}.")

    def return_book(self, book, member):
        if not book.is_issued:
            print(f"Cannot return '{book.title}'. It was not issued.")
        else:
            book.is_issued = False
            self.transactions.append(('Returned', book, member))
            print(f"Book '{book.title}' returned by {member.name}.")
