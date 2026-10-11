INSERT INTO books
(title, description, author, cover, price, stock)
VALUES
(
  'Clean Code',
  'A practical guide to writing clean, readable, and maintainable software.',
  'Robert C. Martin',
  'http://localhost:8080/covers/clean-code.jpg',
  250000, 50
),
(
  'The Pragmatic Programmer',
  'A guide to becoming a better and more effective software developer.',
  'David Thomas',
  'http://localhost:8080/covers/pragmatic-programmer.jpg',
  300000, 35
),
(
  'Design Patterns',
  'An introduction to reusable object-oriented software design patterns.',
  'Erich Gamma',
  'http://localhost:8080/covers/design-patterns.jpg',
  325000, 20
),
(
  'Effective Java',
  'Best practices and guidelines for writing robust Java applications.',
  'Joshua Bloch',
  'http://localhost:8080/covers/effective-java.jpg',
  350000, 25
),
(
  'Head First Java',
  'An approachable introduction to Java programming and object-oriented concepts.',
  'Kathy Sierra',
  'http://localhost:8080/covers/head-first-java.jpg',
  275000, 40
),
(
  'Java Concurrency in Practice',
  'A detailed guide to concurrency and multithreaded programming in Java.',
  'Brian Goetz',
  'http://localhost:8080/covers/java-concurrency.jpg',
  400000, 15
),
(
  'Spring in Action',
  'A practical guide to building applications with the Spring framework.',
  'Craig Walls',
  'http://localhost:8080/covers/spring-in-action.jpg',
  320000, 30
),
(
  'Learning SQL',
  'An introduction to SQL queries, database design, and relational databases.',
  'Alan Beaulieu',
  'http://localhost:8080/covers/learning-sql.jpg',
  250000, 45
),
(
  'Database System Concepts',
  'A comprehensive introduction to database systems and database management.',
  'Abraham Silberschatz',
  'http://localhost:8080/covers/database-system-concepts.jpg',
  420000, 18
),
(
  'Designing Data-Intensive Applications',
  'Principles and practical techniques for building reliable data systems.',
  'Martin Kleppmann',
  'http://localhost:8080/covers/data-intensive-applications.jpg',
  460000, 22
),
(
  'Computer Networking',
  'An introduction to computer networking concepts, protocols, and architectures.',
  'James Kurose',
  'http://localhost:8080/covers/computer-networking.jpg',
  500000, 12
),
(
  'Computer Networks',
  'A detailed study of networking technologies, protocols, and network architecture.',
  'Andrew S. Tanenbaum',
  'http://localhost:8080/covers/computer-networks.jpg',
  450000, 17
),
(
  'Operating System Concepts',
  'A comprehensive introduction to operating systems and system architecture.',
  'Abraham Silberschatz',
  'http://localhost:8080/covers/operating-system-concepts.jpg',
  470000, 14
),
(
  'Computer Architecture',
  'Fundamentals of computer organization, processors, memory, and system design.',
  'David A. Patterson',
  'http://localhost:8080/covers/computer-architecture.jpg',
  415000, 16
),
(
  'Introduction to Algorithms',
  'A comprehensive introduction to algorithms and fundamental computer science techniques.',
  'Thomas H. Cormen',
  'http://localhost:8080/covers/introduction-algorithms.jpg',
  550000, 10
),
(
  'Artificial Intelligence',
  'An introduction to artificial intelligence, intelligent agents, and machine learning.',
  'Stuart Russell',
  'http://localhost:8080/covers/artificial-intelligence.jpg',
  530000, 13
),
(
  'Docker Deep Dive',
  'A practical guide to containers, Docker, and container-based application deployment.',
  'Nigel Poulton',
  'http://localhost:8080/covers/docker-deep-dive.jpg',
  290000, 28
),
(
  'Kubernetes Up and Running',
  'A practical introduction to Kubernetes and container orchestration.',
  'Kelsey Hightower',
  'http://localhost:8080/covers/kubernetes-up-running.jpg',
  370000, 19
),
(
  'Cloud Computing',
  'An introduction to cloud computing concepts, architectures, and services.',
  'Rajkumar Buyya',
  'http://localhost:8080/covers/cloud-computing.jpg',
  385000, 24
),
(
  'The Linux Command Line',
  'A practical introduction to Linux command-line tools and shell programming.',
  'William E. Shotts',
  'http://localhost:8080/covers/linux-command-line.jpg',
  270000, 32
);

INSERT INTO users
(username, password, role)
VALUES
(
  'admin',
  'admin',
  'ADMIN'
),
(
  'alice',
  '12345678',
  'USER'
),
(
  'bob',
  '11112222',
  'USER'
);