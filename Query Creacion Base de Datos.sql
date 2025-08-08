CREATE DATABASE IF NOT EXISTS Biblioteca;
USE Biblioteca;

-- Tabla de Categorías
CREATE TABLE IF NOT EXISTS Categorias (
  CategoriaID INT AUTO_INCREMENT PRIMARY KEY,
  CategoriaDescripcion VARCHAR(255) NOT NULL
);

-- Tabla de Tipo de Usuario
CREATE TABLE IF NOT EXISTS TipoUsuario (
  TipoUsuarioID INT AUTO_INCREMENT PRIMARY KEY,
  DescripcionUsuario VARCHAR(255) NOT NULL
);

-- Tabla de Roles
CREATE TABLE IF NOT EXISTS Rol (
  RolID INT AUTO_INCREMENT PRIMARY KEY,
  RolDescripcion VARCHAR(255) NOT NULL
);

-- Tabla de Autores
CREATE TABLE IF NOT EXISTS Autores (
  AutorID INT AUTO_INCREMENT PRIMARY KEY,
  NombreAutor VARCHAR(255) NOT NULL,
  ApellidoAutor VARCHAR(255) NOT NULL
);

-- Tabla de Libros
CREATE TABLE IF NOT EXISTS Libros (
  LibrosID INT AUTO_INCREMENT PRIMARY KEY,
  Titulo VARCHAR(255) NOT NULL,
  FechaPublicacion DATE,
  CategoriaID INT,
  Edicion VARCHAR(255),
  FOREIGN KEY (CategoriaID) REFERENCES Categorias(CategoriaID)
);

-- Tabla intermedia de relación muchos a muchos entre Libros y Autores
CREATE TABLE IF NOT EXISTS Libros_Autores (
  LibrosID INT,
  AutorID INT,
  PRIMARY KEY (LibrosID, AutorID),
  FOREIGN KEY (LibrosID) REFERENCES Libros(LibrosID),
  FOREIGN KEY (AutorID) REFERENCES Autores(AutorID)
);

-- Tabla de Ejemplares
CREATE TABLE IF NOT EXISTS Ejemplares (
  EjemplarID INT AUTO_INCREMENT PRIMARY KEY,
  LibroID INT,
  FechaIngreso DATE,
  Estado BOOLEAN DEFAULT TRUE,
  FOREIGN KEY (LibroID) REFERENCES Libros(LibrosID)
);

-- Tabla de Usuarios
CREATE TABLE IF NOT EXISTS Usuarios (
  UsuarioID INT AUTO_INCREMENT PRIMARY KEY,
  Correo VARCHAR(255) NOT NULL,
  Telefono VARCHAR(50),
  Direccion VARCHAR(255),
  Nombre VARCHAR(255) NOT NULL,
  Apellido VARCHAR(255) NOT NULL,
  TipoUsuarioID INT,
  Status BOOLEAN DEFAULT TRUE,
  Contraseña VARCHAR(256) NOT NULL,
  FOREIGN KEY (TipoUsuarioID) REFERENCES TipoUsuario(TipoUsuarioID)
);

-- Tabla de Empleados
CREATE TABLE IF NOT EXISTS Empleados (
  EmpleadoID INT AUTO_INCREMENT PRIMARY KEY,
  NombreEmpleado VARCHAR(255) NOT NULL,
  Contraseña VARCHAR(256) NOT NULL,
  RolID INT,
  Status BOOLEAN DEFAULT TRUE,
  FOREIGN KEY (RolID) REFERENCES Rol(RolID)
);

-- Tabla de Préstamos
CREATE TABLE IF NOT EXISTS Prestamos (
  PrestamoID INT AUTO_INCREMENT PRIMARY KEY,
  UsuarioID INT,
  EjemplarID INT,
  FechaEgreso DATE,
  FechaDevolucionEstimada DATE,
  EmpleadoID INT,
  FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID),
  FOREIGN KEY (EjemplarID) REFERENCES Ejemplares(EjemplarID),
  FOREIGN KEY (EmpleadoID) REFERENCES Empleados(EmpleadoID)
);

-- Tabla de Devoluciones
CREATE TABLE IF NOT EXISTS Devoluciones (
  DevolucionID INT AUTO_INCREMENT PRIMARY KEY,
  EjemplarID INT,
  PrestamoID INT,
  FechaDevolucion DATE,
  Comentario VARCHAR(255),
  EmpleadoID INT,
  FOREIGN KEY (EjemplarID) REFERENCES Ejemplares(EjemplarID),
  FOREIGN KEY (PrestamoID) REFERENCES Prestamos(PrestamoID),
  FOREIGN KEY (EmpleadoID) REFERENCES Empleados(EmpleadoID)
);

-- Insercion de datos
-- Insertar Categorías
INSERT INTO Categorias (CategoriaDescripcion) VALUES 
('Ciencia Ficción'), ('Fantasía'), ('Historia'), 
('Matemáticas'), ('Computación'), ('Literatura'), 
('Arte'), ('Filosofía'), ('Biología'), ('Psicología');

-- Insertar Tipo de Usuario
INSERT INTO TipoUsuario (DescripcionUsuario) VALUES 
('Estudiante'), ('Profesor'), ('Interno');

-- Insertar Roles
INSERT INTO Rol (RolDescripcion) VALUES 
('Administrador'), ('Bibliotecario'), ('IT');

-- Insertar Autores
INSERT INTO Autores (NombreAutor, ApellidoAutor) VALUES 
('Isaac', 'Asimov'), 
('J.K.', 'Rowling'), 
('Yuval Noah', 'Harari'), 
('Stephen', 'Hawking'), 
('Donald E.', 'Knuth'), 
('Gabriel', 'García Márquez'), 
('Leonardo', 'Da Vinci'), 
('René', 'Descartes'), 
('Charles', 'Darwin'), 
('Carl', 'Jung');

-- Insertar Libros
INSERT INTO Libros (Titulo, FechaPublicacion, CategoriaID, Edicion) VALUES
('Fundación', '1951-06-01', 1, 'Primera'),
('Harry Potter y la Piedra Filosofal', '1997-06-26', 2, 'Primera'),
('Sapiens: De animales a dioses', '2011-09-04', 3, 'Primera'),
('Breve historia del tiempo', '1988-03-01', 4, 'Tercera'),
('El arte de programar computadoras', '1968-01-01', 5, 'Segunda'),
('Cien años de soledad', '1967-05-30', 6, 'Primera'),
('El tratado de la pintura', '1651-01-01', 7, 'Primera edición moderna'),
('Discurso del método', '1637-01-01', 8, 'Primera edición ilustrada'),
('El origen de las especies', '1859-11-24', 9, 'Primera'),
('El hombre y sus símbolos', '1964-01-01', 10, 'Primera');

-- Insertar Libros_Autores
INSERT INTO Libros_Autores (LibrosID, AutorID) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- Insertar Ejemplares (2 por libro)
INSERT INTO Ejemplares (LibroID, FechaIngreso, Estado) VALUES
(1, '2022-02-15', 1),
(1, '2022-02-16', 0),
(2, '2022-03-01', 1),
(2, '2022-03-02', 1),
(3, '2022-04-10', 1),
(3, '2022-04-11', 0),
(4, '2022-05-05', 1),
(4, '2022-05-06', 1),
(5, '2022-06-20', 1),
(5, '2022-06-21', 0);

-- Insertar Usuarios
INSERT INTO Usuarios (Correo, Telefono, Direccion, Nombre, Apellido, TipoUsuarioID, Status, Contraseña) VALUES
('ana.lopez@mail.com', '504-22330044', 'Av. La Paz #123', 'Ana', 'López', 1, 1, 'hashAna2025'),
('carlos.martinez@mail.com', '504-22330045', 'Col. El Prado #45', 'Carlos', 'Martínez', 1, 1, 'hashCarlito'),
('marisol.ramirez@mail.com', '504-22330046', 'Calle Central #789', 'Marisol', 'Ramírez', 2, 1, 'hashMari'),
('juan.perez@mail.com', '504-22330047', 'Boulevar Morazán #56', 'Juan', 'Pérez', 1, 1, 'hashJuan'),
('luis.gomez@mail.com', '504-22330048', 'Col. El Centro #98', 'Luis', 'Gómez', 1, 1, 'hashLuis'),
('elena.herrera@mail.com', '504-22330049', 'Av. La Reforma #112', 'Elena', 'Herrera', 1, 1, 'hashElena'),
('maria.vargas@mail.com', '504-22330050', 'Calle Real #5', 'María', 'Vargas', 1, 1, 'hashMaria'),
('roberto.ruiz@mail.com', '504-22330051', 'Col. Montecillo #21', 'Roberto', 'Ruíz', 1, 1, 'hashRoberto'),
('sofia.mendez@mail.com', '504-22330052', 'Av. Max León #34', 'Sofía', 'Méndez', 2, 1, 'hashSofia'),
('diego.castillo@mail.com', '504-22330053', 'Callejón Suazo #7', 'Diego', 'Castillo', 2, 1, 'hashDiego');

-- Insertar Empleados
INSERT INTO Empleados (NombreEmpleado, Contraseña, RolID, Status) VALUES
('Luis Hernández', '$2a$12$5a73SnF6ZAm740x2lnEW4eKQr9uqELgWITMVC8Fo.YLgI0kF3ftLi', 1, 1),
('María Torres', '$2a$12$zKWXlvObEKuwyn06AkFd3O0qKFcGrSKoZkvaOSuvsEh55hM/kR4z6', 2, 1),
('Jorge Díaz', '$2a$12$gsXpGQiFO3U0bfwBy2VbB.nHjXdB6vyzgxzNmQPCjXR9wLkUvUj4a', 2, 1),
('Patricia Silva', '$2a$12$J1D9IypwwfmdyURraOOQwuD5tl2vO2dU6a2I.hvnRGO2F.3Xc4qRq', 2, 1),
('Andrés Ramírez', '$2a$12$tDX14IBl1P3YqvNckEB0OeOjm1Bv9Cf/Y1OuA7saYDzZw4j6PmUx2', 2, 1),
('Verónica López', '$2a$12$lTVODWVDxnAROY9uS/wDTuZGn5JBi8opmHMTIzPh1y1P/DEpKOtOy', 2, 1),
('José Figueroa', '$2a$12$8i3Zhhfm1gvY2M4ZyJWzlO0eNoLDt7TNcfJXZGER7CfyhzlZ/7Sk6', 2, 1),
('Claudia Méndez', '$2a$12$QmDuJGromSND2n1ZzDe4UOztlmfTM22sb8iqHLjLMjVdrW3HeV.Xm', 3, 1),
('Ricardo Cruz', '$2a$12$L9Zeku7.r/OYVCIaljB24uDuVZ5.srl571iyy1EVKNGGfrpyGVOWe', 2, 1),
('Gabriela Morales', '$2a$12$qxytQcXKfS8Sc.FhWkgXGO4JH076aNuGnkyQNOsvVQCClZoBiT5wO', 2, 1);

-- Insertar Préstamos
INSERT INTO Prestamos (UsuarioID, EjemplarID, FechaEgreso, FechaDevolucionEstimada, EmpleadoID) VALUES
(1, 2, '2025-06-01', '2025-06-15', 2),
(3, 5, '2025-06-02', '2025-06-16', 1),
(5, 7, '2025-06-03', '2025-06-17', 3),
(2, 8, '2025-06-04', '2025-06-18', 4),
(4, 1, '2025-06-05', '2025-06-19', 5),
(6, 3, '2025-06-06', '2025-06-20', 6),
(7, 9, '2025-06-07', '2025-06-21', 7),
(8, 4, '2025-06-08', '2025-06-22', 8),
(9, 6, '2025-06-09', '2025-06-23', 9),
(10, 10, '2025-05-10', '2025-05-24', 10);

-- Insertar Devoluciones
INSERT INTO Devoluciones (EjemplarID, PrestamoID, FechaDevolucion, Comentario, EmpleadoID) VALUES
(2, 1, '2025-06-12', 'Devuelto en buen estado', 3),
(5, 2, '2025-06-13', 'Pequeña manchas en páginas', 1),
(7, 3, '2025-06-14', 'Desgaste leve tapa', 2),
(8, 4, '2025-06-15', 'Todo en orden', 4),
(1, 5, '2025-06-16', 'Tapa un poco doblada', 5),
(3, 6, '2025-06-17', 'Marcas en página 50', 6),
(9, 7, '2025-06-18', 'Pequeña rasgadura en contraportada', 7),
(4, 8, '2025-06-19', 'Libro impecable', 8);


-- Creacion de Indices
CREATE INDEX idx_libros_titulo ON Libros(Titulo);
CREATE INDEX idx_autores_autorid ON Autores(AutorID);
CREATE INDEX idx_usuarios_usuarioid ON Usuarios(UsuarioID);

-- Consultas avanzadas
/*1. Libros pautoresrestados por usuario */
SELECT 
  CONCAT(u.Nombre, ' ', u.Apellido) AS NombreCompleto,
  l.Titulo,
  p.FechaEgreso
FROM Prestamos p
JOIN Usuarios u ON p.UsuarioID = u.UsuarioID
JOIN Ejemplares e ON p.EjemplarID = e.EjemplarID
JOIN Libros l ON e.LibroID = l.LibrosID;

-- 2. Libros no devueltos despues de la fecha limite
SELECT 
  u.Nombre, u.Apellido, l.Titulo, p.FechaDevolucionEstimada
FROM Prestamos p
JOIN Usuarios u ON p.UsuarioID = u.UsuarioID
JOIN Ejemplares e ON p.EjemplarID = e.EjemplarID
JOIN Libros l ON e.LibroID = l.LibrosID
LEFT JOIN Devoluciones d ON p.PrestamoID = d.PrestamoID
WHERE d.PrestamoID IS NULL AND CURDATE() > p.FechaDevolucionEstimada;

-- 3. Libros mas populares.
CREATE VIEW LibrosMasPopulares AS
SELECT 
  l.Titulo, COUNT(*) AS TotalPrestamos
FROM Prestamos p
JOIN Ejemplares e ON p.EjemplarID = e.EjemplarID
JOIN Libros l ON e.LibroID = l.LibrosID
GROUP BY l.LibrosID
ORDER BY TotalPrestamos DESC
LIMIT 5;

-- 4. Autores con mas publicaciones.
SELECT 
  a.NombreAutor, a.ApellidoAutor, COUNT(*) AS TotalLibros
FROM Libros_Autores la
JOIN Autores a ON la.AutorID = a.AutorID
GROUP BY la.AutorID
ORDER BY TotalLibros DESC;

-- 5. Prestamos realizados por mes
SELECT 
  DATE_FORMAT(FechaEgreso, '%Y-%m') AS Mes,
  COUNT(*) AS TotalPrestamos
FROM Prestamos
GROUP BY Mes
ORDER BY Mes DESC;

-- 6. Total de libros prestados por categoria
SELECT 
  c.CategoriaDescripcion, COUNT(*) AS TotalPrestamos
FROM Prestamos p
JOIN Ejemplares e ON p.EjemplarID = e.EjemplarID
JOIN Libros l ON e.LibroID = l.LibrosID
JOIN Categorias c ON l.CategoriaID = c.CategoriaID
GROUP BY c.CategoriaID
ORDER BY TotalPrestamos DESC;

-- 7. Usuarios con mas prestamos
SELECT 
  u.Nombre, u.Apellido, COUNT(*) AS TotalPrestamos
FROM Prestamos p
JOIN Usuarios u ON p.UsuarioID = u.UsuarioID
GROUP BY p.UsuarioID
ORDER BY TotalPrestamos DESC
LIMIT 5;

-- 8. Libros actualmente prestados
SELECT 
  l.Titulo, u.Nombre, u.Apellido
FROM Prestamos p
JOIN Ejemplares e ON p.EjemplarID = e.EjemplarID
JOIN Libros l ON e.LibroID = l.LibrosID
JOIN Usuarios u ON p.UsuarioID = u.UsuarioID
LEFT JOIN Devoluciones d ON p.PrestamoID = d.PrestamoID
WHERE d.PrestamoID IS NULL;

-- 9. Ejemplares dañados o con comentarios de devolucion
SELECT 
  l.Titulo, d.Comentario
FROM Devoluciones d
JOIN Ejemplares e ON d.EjemplarID = e.EjemplarID
JOIN Libros l ON e.LibroID = l.LibrosID
WHERE d.Comentario IS NOT NULL AND d.Comentario != '';

-- 10. Promedio de dias de prestamo por categoria
SELECT 
  c.CategoriaDescripcion,
  AVG(DATEDIFF(d.FechaDevolucion, p.FechaEgreso)) AS PromedioDiasPrestamo
FROM Prestamos p
JOIN Devoluciones d ON p.PrestamoID = d.PrestamoID
JOIN Ejemplares e ON p.EjemplarID = e.EjemplarID
JOIN Libros l ON e.LibroID = l.LibrosID
JOIN Categorias c ON l.CategoriaID = c.CategoriaID
GROUP BY c.CategoriaID;

-- 11. Simulacion de multa por devoluciones tardias
SELECT 
  u.Nombre, u.Apellido, l.Titulo,
  GREATEST(DATEDIFF(d.FechaDevolucion, p.FechaDevolucionEstimada), 0) AS DiasRetraso,
  GREATEST(DATEDIFF(d.FechaDevolucion, p.FechaDevolucionEstimada), 0) * 10 AS Multa
FROM Devoluciones d
JOIN Prestamos p ON d.PrestamoID = p.PrestamoID
JOIN Ejemplares e ON d.EjemplarID = e.EjemplarID
JOIN Libros l ON e.LibroID = l.LibrosID
JOIN Usuarios u ON p.UsuarioID = u.UsuarioID
WHERE d.FechaDevolucion > p.FechaDevolucionEstimada;

-- Procedimiento para registrar prestamo y actualizar estado de ejemplar
DELIMITER $$

CREATE PROCEDURE RegistrarPrestamo (
  IN p_UsuarioID INT,
  IN p_EjemplarID INT,
  IN p_FechaEgreso DATE,
  IN p_FechaDevolucionEstimada DATE,
  IN p_EmpleadoID INT
)
BEGIN
  DECLARE ejemplar_disponible BOOLEAN;

  -- Verifica si el ejemplar está disponible (Estado = 1)
  SELECT Estado INTO ejemplar_disponible
  FROM Ejemplares
  WHERE EjemplarID = p_EjemplarID;

  -- Si el ejemplar está disponible, se procede
  IF ejemplar_disponible = 1 THEN
    INSERT INTO Prestamos (UsuarioID, EjemplarID, FechaEgreso, FechaDevolucionEstimada, EmpleadoID)
    VALUES (p_UsuarioID, p_EjemplarID, p_FechaEgreso, p_FechaDevolucionEstimada, p_EmpleadoID);

    UPDATE Ejemplares
    SET Estado = 0
    WHERE EjemplarID = p_EjemplarID;

  ELSE
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'El ejemplar no está disponible para préstamo.';
  END IF;
END $$

DELIMITER ;
-- Ejecucion del procedimiento

CALL RegistrarPrestamo(1, 3, '2024-04-14', '2024-04-28', 2);

-- Explain 1 Consultar popularidad de libros
EXPLAIN SELECT 
  l.Titulo, COUNT(*) AS TotalPrestamos
FROM Prestamos p
JOIN Ejemplares e ON p.EjemplarID = e.EjemplarID
JOIN Libros l ON e.LibroID = l.LibrosID
GROUP BY l.LibrosID;

-- Explain 2 Consulta libros no devueltos a tiempo
EXPLAIN SELECT 
  u.Nombre, u.Apellido, l.Titulo, p.FechaDevolucionEstimada
FROM Prestamos p
JOIN Usuarios u ON p.UsuarioID = u.UsuarioID
JOIN Ejemplares e ON p.EjemplarID = e.EjemplarID
JOIN Libros l ON e.LibroID = l.LibrosID
LEFT JOIN Devoluciones d ON p.PrestamoID = d.PrestamoID
WHERE d.PrestamoID IS NULL AND CURDATE() > p.FechaDevolucionEstimada;