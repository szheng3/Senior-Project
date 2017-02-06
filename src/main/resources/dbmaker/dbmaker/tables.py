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
    salt = Column(String)

    firstname = Column(String)
    lastname = Column(String)
    email = Column(String)

    def __repr__(self):
        return "<User(username='%s')>" % self.username

class Activity(User):
    __tablename__ = 'activity'
    id = Column(Integer, primary_key=True)