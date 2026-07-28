$baseDir = "C:\Users\Administrador\Desktop\T4"

$services = @(
    @{ name = "service-registry"; dir = "service-registry" },
    @{ name = "school-service";   dir = "school.service" },
    @{ name = "student-service";  dir = "student.service" },
    @{ name = "api-gateway";      dir = "api-gateway" }
)

foreach ($service in $services) {
    $path = Join-Path $baseDir $service.dir
    Write-Host "Iniciando $($service.name)..."
    Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd '$path'; .\mvnw.cmd spring-boot:run" -WindowStyle Normal
    Start-Sleep -Seconds 15
}

Write-Host "`nTodos os servicos foram iniciados!"
