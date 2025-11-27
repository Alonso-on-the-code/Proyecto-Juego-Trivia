package trivia.persistence;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileOutputStream;
import java.util.List;
import trivia.models.CompraExtra;
import trivia.models.PlanPremium;
import trivia.models.Usuario;
import trivia.utils.ControladorPagos;

public class GeneradorPDF {

    // ======================================================
    //   CARGAR ICONO DEL JUEGO (FUNCIONAL + SEGURO)
    // ======================================================
    private static Image obtenerIcono() {
    try {
        return Image.getInstance("src/com/mycompany/trivia/imagenes/icono.png");
    } catch (Exception e) {
        System.out.println("NO SE PUDO CARGAR ICONO: " + e);
        return null;
    }
}



    // ======================================================
    //   FORMATO DE PDF PROFESIONAL (TIPOGRAFÍAS)
    // ======================================================
    private static Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, BaseColor.DARK_GRAY);
    private static Font subtituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.GRAY);
    private static Font textoFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
    private static LineSeparator separador = new LineSeparator();


    // ======================================================
    //   1. REPORTE DE PUNTAJES
    // ======================================================
    public static void generarReportePuntajes(List<Usuario> usuarios) {
        try {
            Document doc = new Document(PageSize.A4);
            PdfWriter.getInstance(doc, new FileOutputStream("reporte_puntajes.pdf"));
            doc.open();

            System.out.println(GeneradorPDF.class.getResource("/com/mycompany/trivia/imagenes/icono.png"));

            
            // ICONO
            Image icono = obtenerIcono();
            if (icono != null) {
                icono.scaleToFit(80, 80);
                icono.setAlignment(Element.ALIGN_CENTER);
                doc.add(icono);
            }

            doc.add(new Paragraph("REPORTE DE PUNTAJES", tituloFont));
            doc.add(separador);
            doc.add(new Paragraph("\nGenerado automáticamente por Trivia\n\n", subtituloFont));

            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);

            tabla.addCell("Nombre");
            tabla.addCell("Partidas jugadas");
            tabla.addCell("Puntaje total");

            for (Usuario u : usuarios) {
                tabla.addCell(u.getNombre());
                tabla.addCell(String.valueOf(u.getPartidasJugadas()));
                tabla.addCell(String.valueOf(u.getPuntajeTotal()));
            }

            doc.add(tabla);
            doc.close();
            System.out.println("✅ PDF 'reporte_puntajes.pdf' generado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ======================================================
    //   2. CERTIFICADO DE LOGRO
    // ======================================================
    public static void generarCertificado(Usuario usuario) {
        try {
            String archivo = "certificado_" + usuario.getNombre() + ".pdf";
            Document doc = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(doc, new FileOutputStream(archivo));
            doc.open();

            Image icono = obtenerIcono();
            if (icono != null) {
                icono.scaleToFit(100, 100);
                icono.setAlignment(Element.ALIGN_CENTER);
                doc.add(icono);
            }

            doc.add(new Paragraph("\n🏆 CERTIFICADO DE LOGRO 🏆\n", tituloFont));
            doc.add(separador);

            Paragraph nombre = new Paragraph(usuario.getNombre(), 
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 40, BaseColor.BLUE));
            nombre.setAlignment(Element.ALIGN_CENTER);

            doc.add(new Paragraph("\nEste certificado se otorga a:\n", subtituloFont));
            doc.add(nombre);

            doc.add(new Paragraph(
                "\nPor alcanzar un total de " + usuario.getPuntajeTotal() + " puntos en Trivia.\n",
                textoFont
            ));

            doc.add(new Paragraph("Fecha: " + new java.util.Date().toString(), textoFont));
            doc.add(new Paragraph("\nFirma: ____________________________", textoFont));

            doc.add(new Paragraph("\n\n¡Excelente desempeño! 🎉", subtituloFont));

            doc.close();
            System.out.println("✅ Certificado generado: " + archivo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ======================================================
    //   3. REPORTE DE USUARIOS PREMIUM
    // ======================================================
    public static void generarPDFPremium(String ruta) {
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(ruta));
            doc.open();

            Image icono = obtenerIcono();
            if (icono != null) {
                icono.scaleToFit(70, 70);
                icono.setAlignment(Element.ALIGN_CENTER);
                doc.add(icono);
            }

            doc.add(new Paragraph("REPORTE DE USUARIOS PREMIUM", tituloFont));
            doc.add(separador);
            doc.add(new Paragraph("\n", textoFont));

            for (PlanPremium p : ControladorPagos.getPlanes()) {
                doc.add(new Paragraph(
                    "Usuario: " + p.getUsuario() +
                    "  |  Precio: " + p.getPrecio() +
                    "  |  Fecha: " + p.getFechaInicio(),
                    textoFont
                ));
            }

            doc.add(new Paragraph("\nTotal ingresos: " + ControladorPagos.totalIngresoPremium(), subtituloFont));

            doc.close();
            System.out.println("✅ PDF Premium generado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ======================================================
    //   4. REPORTE DE EXTRAS
    // ======================================================
    public static void generarPDFExtras(String ruta) {
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(ruta));
            doc.open();

            Image icono = obtenerIcono();
            if (icono != null) {
                icono.scaleToFit(70, 70);
                icono.setAlignment(Element.ALIGN_CENTER);
                doc.add(icono);
            }

            doc.add(new Paragraph("REPORTE DE SERVICIOS EXTRA", tituloFont));
            doc.add(separador);
            doc.add(new Paragraph("\n", textoFont));

            for (CompraExtra c : ControladorPagos.getCompras()) {
                doc.add(new Paragraph(
                    "Usuario: " + c.getUsuario() +
                    "  |  Servicio: " + c.getServicio() +
                    "  |  Precio: " + c.getPrecio(),
                    textoFont
                ));
            }

            doc.add(new Paragraph("\nTotal ingresos: " + ControladorPagos.totalIngresoExtras(), subtituloFont));

            doc.close();
            System.out.println("✅ PDF Extras generado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
