$ports = @(8761, 8082, 8081, 8080)

foreach ($port in $ports) {
    $procId = (netstat -ano | Select-String ":$port " | Where-Object { $_ -match 'LISTENING' } | ForEach-Object { ($_ -split '\s+')[-1] }) | Select-Object -First 1
    if ($procId) {
        Write-Host "Matando processo na porta $port (PID $procId)..."
        taskkill /PID $procId /F
    } else {
        Write-Host "Porta $port ja esta livre."
    }
}

Write-Host "`nProntos! Todas as portas foram liberadas."
