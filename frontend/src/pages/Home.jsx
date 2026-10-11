const books = [
  {
    "id": 1,
    "title": "Clean Code",
    "description": "A practical guide to writing clean, readable, and maintainable software.",
    "author": "Robert C. Martin",
    "cover": "http://localhost:8080/covers/clean-code.jpg",
    "price": 250000,
    "stock": 50
  },
  {
    "id": 2,
    "title": "The Pragmatic Programmer",
    "description": "A guide to becoming a better and more effective software developer.",
    "author": "David Thomas",
    "cover": "http://localhost:8080/covers/pragmatic-programmer.jpg",
    "price": 300000,
    "stock": 35
  },
  {
    "id": 3,
    "title": "Design Patterns",
    "description": "An introduction to reusable object-oriented software design patterns.",
    "author": "Erich Gamma",
    "cover": "http://localhost:8080/covers/design-patterns.jpg",
    "price": 325000,
    "stock": 20
  },
  {
    "id": 4,
    "title": "Effective Java",
    "description": "Best practices and guidelines for writing robust Java applications.",
    "author": "Joshua Bloch",
    "cover": "http://localhost:8080/covers/effective-java.jpg",
    "price": 350000,
    "stock": 25
  },
  {
    "id": 5,
    "title": "Head First Java",
    "description": "An approachable introduction to Java programming and object-oriented concepts.",
    "author": "Kathy Sierra",
    "cover": "http://localhost:8080/covers/head-first-java.jpg",
    "price": 275000,
    "stock": 40
  },
  {
    "id": 6,
    "title": "Java Concurrency in Practice",
    "description": "A detailed guide to concurrency and multithreaded programming in Java.",
    "author": "Brian Goetz",
    "cover": "http://localhost:8080/covers/java-concurrency.jpg",
    "price": 400000,
    "stock": 15
  },
  {
    "id": 7,
    "title": "Spring in Action",
    "description": "A practical guide to building applications with the Spring framework.",
    "author": "Craig Walls",
    "cover": "http://localhost:8080/covers/spring-in-action.jpg",
    "price": 320000,
    "stock": 30
  },
  {
    "id": 8,
    "title": "Learning SQL",
    "description": "An introduction to SQL queries, database design, and relational databases.",
    "author": "Alan Beaulieu",
    "cover": "http://localhost:8080/covers/learning-sql.jpg",
    "price": 250000,
    "stock": 45
  },
  {
    "id": 9,
    "title": "Database System Concepts",
    "description": "A comprehensive introduction to database systems and database management.",
    "author": "Abraham Silberschatz",
    "cover": "http://localhost:8080/covers/database-system-concepts.jpg",
    "price": 420000,
    "stock": 18
  },
  {
    "id": 10,
    "title": "Designing Data-Intensive Applications",
    "description": "Principles and practical techniques for building reliable data systems.",
    "author": "Martin Kleppmann",
    "cover": "http://localhost:8080/covers/data-intensive-applications.jpg",
    "price": 460000,
    "stock": 22
  },
  {
    "id": 11,
    "title": "Computer Networking",
    "description": "An introduction to computer networking concepts, protocols, and architectures.",
    "author": "James Kurose",
    "cover": "http://localhost:8080/covers/computer-networking.jpg",
    "price": 500000,
    "stock": 12
  },
  {
    "id": 12,
    "title": "Computer Networks",
    "description": "A detailed study of networking technologies, protocols, and network architecture.",
    "author": "Andrew S. Tanenbaum",
    "cover": "http://localhost:8080/covers/computer-networks.jpg",
    "price": 450000,
    "stock": 17
  },
  {
    "id": 13,
    "title": "Operating System Concepts",
    "description": "A comprehensive introduction to operating systems and system architecture.",
    "author": "Abraham Silberschatz",
    "cover": "http://localhost:8080/covers/operating-system-concepts.jpg",
    "price": 470000,
    "stock": 14
  },
  {
    "id": 14,
    "title": "Computer Architecture",
    "description": "Fundamentals of computer organization, processors, memory, and system design.",
    "author": "David A. Patterson",
    "cover": "http://localhost:8080/covers/computer-architecture.jpg",
    "price": 415000,
    "stock": 16
  },
  {
    "id": 15,
    "title": "Introduction to Algorithms",
    "description": "A comprehensive introduction to algorithms and fundamental computer science techniques.",
    "author": "Thomas H. Cormen",
    "cover": "http://localhost:8080/covers/introduction-algorithms.jpg",
    "price": 550000,
    "stock": 10
  },
  {
    "id": 16,
    "title": "Artificial Intelligence",
    "description": "An introduction to artificial intelligence, intelligent agents, and machine learning.",
    "author": "Stuart Russell",
    "cover": "http://localhost:8080/covers/artificial-intelligence.jpg",
    "price": 530000,
    "stock": 13
  },
  {
    "id": 17,
    "title": "Docker Deep Dive",
    "description": "A practical guide to containers, Docker, and container-based application deployment.",
    "author": "Nigel Poulton",
    "cover": "http://localhost:8080/covers/docker-deep-dive.jpg",
    "price": 290000,
    "stock": 28
  },
  {
    "id": 18,
    "title": "Kubernetes Up and Running",
    "description": "A practical introduction to Kubernetes and container orchestration.",
    "author": "Kelsey Hightower",
    "cover": "http://localhost:8080/covers/kubernetes-up-running.jpg",
    "price": 370000,
    "stock": 19
  },
  {
    "id": 19,
    "title": "Cloud Computing",
    "description": "An introduction to cloud computing concepts, architectures, and services.",
    "author": "Rajkumar Buyya",
    "cover": "http://localhost:8080/covers/cloud-computing.jpg",
    "price": 385000,
    "stock": 24
  },
  {
    "id": 20,
    "title": "The Linux Command Line",
    "description": "A practical introduction to Linux command-line tools and shell programming.",
    "author": "William E. Shotts",
    "cover": "http://localhost:8080/covers/linux-command-line.jpg",
    "price": 270000,
    "stock": 32
  }
]

export default function Home() {

  return (
    <div className="w-full flex flex-wrap p-[1px]">
      {books.map(book => <div className="w-[240px] h-[320px] m-[5px] border border-gray-300 rounded-lg overflow-hidden flex flex-col" key={book.id}>
        <div className="overflow-hidden">
          <img className="w-full aspect-square hover:scale-[1.1] transition-transform duration-500 cursor-pointer" src={book.cover} alt="cover" />
        </div>
        <div className="w-full flex-1 min-h-0 overflow-hidden ml-[10px] mr-[10px]">
          <span className="hover:text-blue-500 cursor-pointer">
            {book.title}
          </span>
        </div>
        <div className="font-bold text-blue-800 ml-[10px] mr-[10px]">
          {book.price} VNĐ
        </div>
      </div>)}
    </div>
  );
}