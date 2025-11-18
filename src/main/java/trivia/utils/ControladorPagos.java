package trivia.utils;

import trivia.models.PlanPremium;
import trivia.models.CompraExtra;
import trivia.persistence.FileManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ControladorPagos {

    private static List<PlanPremium> planes = new ArrayList<>();
    private static List<CompraExtra> compras = new ArrayList<>();
    private static DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // ============================================
    // CARGA Y GUARDADO EN ARCHIVOS (IMPORTANTE)
    // ============================================
    public static void cargarDatosPagos() {
        planes = FileManager.cargarPlanes();
        compras = FileManager.cargarCompras();
    }

    public static void guardarDatosPagos() {
        FileManager.guardarPlanes(planes);
        FileManager.guardarCompras(compras);
    }

    // ============================================
    // AGREGAR DATOS
    // ============================================
    public static void addPlan(PlanPremium p) {
        planes.add(p);
        guardarDatosPagos();
    }

    public static void addCompra(CompraExtra c) {
        compras.add(c);
        guardarDatosPagos();
    }

    // ============================================
    // GETTERS
    // ============================================
    public static List<PlanPremium> getPlanes() { return planes; }
    public static List<CompraExtra> getCompras() { return compras; }

    // ============================================
    // CALCULOS BASICOS PARA PDFs
    // ============================================
    public static double totalIngresoPremium() {
        return planes.stream().mapToDouble(PlanPremium::getPrecio).sum();
    }

    public static double totalIngresoExtras() {
        return compras.stream().mapToDouble(CompraExtra::getPrecio).sum();
    }

    public static double gastoPromedioPorUsuario() {
        Map<String, Double> sumaPorUsuario = compras.stream()
                .collect(Collectors.groupingBy(CompraExtra::getUsuario,
                        Collectors.summingDouble(CompraExtra::getPrecio)));

        if(sumaPorUsuario.isEmpty()) return 0.0;

        return sumaPorUsuario.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static List<Map.Entry<String, Double>> topCompradores(int topN) {
        Map<String, Double> sumaPorUsuario = compras.stream()
                .collect(Collectors.groupingBy(CompraExtra::getUsuario,
                        Collectors.summingDouble(CompraExtra::getPrecio)));

        return sumaPorUsuario.entrySet()
                .stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .limit(topN)
                .collect(Collectors.toList());
    }

    public static double porcentajePremium(int totalUsuarios) {
        if(totalUsuarios == 0) return 0.0;

        Set<String> usuariosPremium =
                planes.stream().map(PlanPremium::getUsuario).collect(Collectors.toSet());

        return (usuariosPremium.size() * 100.0) / totalUsuarios;
    }

    // ============================================
    // CALCULO DE CRECIMIENTO
    // ============================================
    public static double crecimientoPorcentual(double mesAnterior, double mesActual) {
        if(mesAnterior == 0) return mesActual == 0 ? 0 : 100;
        return ((mesActual - mesAnterior) / mesAnterior) * 100.0;
    }

    // ============================================
    // AGRUPACIONES POR MES
    // ============================================
    public static Map<String, Double> ingresosPorMesPremium() {
        return planes.stream().collect(Collectors.groupingBy(
                p -> p.getFechaInicio().substring(0, 7),
                Collectors.summingDouble(PlanPremium::getPrecio)
        ));
    }

    public static Map<String, Double> ingresosPorMesExtras() {
        return compras.stream().collect(Collectors.groupingBy(
                c -> c.getFecha().substring(0, 7),
                Collectors.summingDouble(CompraExtra::getPrecio)
        ));
    }

    // ============================================
    // FECHA
    // ============================================
    public static String hoy() {
        return LocalDate.now().format(f);
    }
}
