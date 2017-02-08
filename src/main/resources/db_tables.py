from sqlalchemy import Column
from sqlalchemy import Integer
from sqlalchemy import String
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker


Base = declarative_base()


class User(Base):
	__tablename__ = 'user'
	username = Column(String, primary_key=True)
	password = Column(String, nullable=False)

	def __repr__(self):
		return "<User(username='%s'>" % self.username


# Making a connection object
#engine = create_engine('sqlite:///:memory:', echo=True)
engine = create_engine('sqlite:///user_db.sqlite', echo=True)
# Creating the schema
Base.metadata.create_all(engine)

## Making a Session class, which serves as a factory for new Session objects.
# Session objects are the handel to the database
Session = sessionmaker(bind=engine)
session = Session()

# Create a new user
new_user = User(username='test_user', password='password')

session.add(new_user)

session.commit()